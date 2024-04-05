<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('alumnos', function (Blueprint $table) {
            $table->id('codigoAlumno'); //codigoAlumno, int, primary
            $table->string('nombre', 50);
            $table->string('apellido',50);
            $table->string('correo',100);
            $table->string('telefono',100);
            $table->text('direccion',1000);
            $table->integer('codigoCarrera');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('alumnos');
    }
};
